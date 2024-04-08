import { Component } from '@angular/core';
import { ApiService } from '../service/api.service';
import { RequiredRemainderRequest } from '../model/RequiredRemainderRequest';
import { FormsModule } from '@angular/forms';
import { Utils } from '../utils/Utils';
import { RequiredRemainderResponse } from '../model/RequiredRemainderResponse';

@Component({
  selector: 'page-content',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './page-content.component.html',
  styleUrl: './page-content.component.scss'
})
export class PageContentComponent {
  solutionRequiredRemainder!: string;
  errorList!: string[];
  xField!: number;
  yField!: number;
  nField!: number;

  constructor(private apiService:ApiService){}

  getCall() {
    this.errorList = [];
    this.solutionRequiredRemainder = "";
    if (this.validateFieldsNumber()) {
      this.apiService.getCall(this.xField, this.yField, this.nField).subscribe({
        next: (response: RequiredRemainderResponse) => {
          this.solutionRequiredRemainder = response.result + ' from get call';
        }, 
        error: (error) => {
          this.errorList = error?.error?.errors;
        }
      });
    }
  }

  postCall() {
    this.errorList = [];
    this.solutionRequiredRemainder = "";
    if (this.validateFieldsNumber()) {
      const requiredRemainderRequest: RequiredRemainderRequest = {
        x: this.xField,
        y: this.yField,
        n: this.nField
      };
      this.apiService.postCall(requiredRemainderRequest).subscribe({
        next: (response: RequiredRemainderResponse) => {
          this.solutionRequiredRemainder = response.result + ' from post call';
        }, 
        error: (error) => {
          this.errorList = error?.error?.errors;
        }
      });
    }
  }

  validateFieldsNumber(): boolean {
    if (Utils.valueIsNotNumber(this.xField)) {
      this.errorList.push("x field should be a number")
    }
    if (Utils.valueIsNotNumber(this.yField)) {
      this.errorList.push("y field should be a number")
    }
    if (Utils.valueIsNotNumber(this.nField)) {
      this.errorList.push("n field should be a number")
    }

    if (this.errorList?.length > 0) return false; else return true;
  }
}

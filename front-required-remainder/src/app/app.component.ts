import { RequiredRemainderBody } from './model/RequiredRemainderBody';
import { ApiService } from './service/api.service';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'Required Remainder App';
  solutionRequiredRemainder!: string;
  xField!: number;
  yField!: number;
  nField!: number;

  constructor(private apiService:ApiService){}

  getCall() {
    this.apiService.getCall(this.xField, this.yField, this.nField).subscribe(response => {
      this.solutionRequiredRemainder = response + ' from get call';
    });
  }

  postCall() {
    const requiredRemainderBody: RequiredRemainderBody = {
      x: this.xField,
      y: this.yField,
      n: this.nField
    };
    this.apiService.postCall(requiredRemainderBody).subscribe(response => {
      this.solutionRequiredRemainder = response + ' from post call';
    });
  }
}

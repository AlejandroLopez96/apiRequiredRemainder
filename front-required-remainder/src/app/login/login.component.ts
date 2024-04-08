import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../service/login.service';
import { User } from '../model/User';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent implements OnInit {

  model: any = {};
  loading: boolean = false;

  constructor(
      private loginService: LoginService,
      private router: Router
  ) { }

  ngOnInit() {
      sessionStorage.setItem('token', '');
  }

  login() {
    this.loading = true;
    this.loginService.login(this.model).subscribe(isValid => {
      this.loading = false;
        if (isValid) {
            sessionStorage.setItem('token', btoa(this.model.username + ':' + this.model.password));
            this.router.navigate(['']);
        } else {
            alert("Authentication failed.")
        }
    });
  }
}
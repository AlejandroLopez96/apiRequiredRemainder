import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'page-header',
  standalone: true,
  imports: [],
  templateUrl: './page-header.component.html',
  styleUrl: './page-header.component.scss'
})
export class PageHeaderComponent {
  title = 'Required Remainder App';

  constructor(private router: Router){}

  logout() {
    sessionStorage.removeItem('token');
    this.router.navigate(['/login']);
  }

}

import { Component } from '@angular/core';
import { PageHeaderComponent } from '../page-header/page-header.component';
import { PageContentComponent } from '../page-content/page-content.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [PageHeaderComponent, PageContentComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

}

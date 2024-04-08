import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/User';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  baseUrlApi: string = 'http://localhost:8085';
  urlLoginApi: string = '/login';

  constructor(private http: HttpClient) {}

  login(user: User): Observable<boolean> {
    return this.http.post<boolean>(`${this.baseUrlApi}${this.urlLoginApi}`, user);
  }

}

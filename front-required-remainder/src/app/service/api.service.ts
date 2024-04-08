import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { RequiredRemainderResponse } from '../model/RequiredRemainderResponse';
import { RequiredRemainderRequest } from '../model/RequiredRemainderRequest';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  baseUrlApi: string = 'http://localhost:8085';
  urlApi: string = '/required-remainder/calculate';
  
  headers: HttpHeaders = new HttpHeaders({
    'Authorization': 'Basic ' + sessionStorage.getItem('token')
  });

  constructor(private http: HttpClient) {}

  getCall(x: number, y: number, n: number): Observable<RequiredRemainderResponse> {
    let options = { headers: this.headers };
    return this.http.get<RequiredRemainderResponse>(`${this.baseUrlApi}${this.urlApi}?x=${x}&y=${y}&n=${n}`, options);
  }

  postCall(requiredRemainderBody: RequiredRemainderRequest): Observable<RequiredRemainderResponse> {
    let options = { headers: this.headers };
    return this.http.post<RequiredRemainderResponse>(`${this.baseUrlApi}${this.urlApi}`, requiredRemainderBody, options);
  }
}

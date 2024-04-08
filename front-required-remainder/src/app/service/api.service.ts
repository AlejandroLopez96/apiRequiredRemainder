import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { RequiredRemainderBody } from '../model/RequiredRemainderBody';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  baseUrlApi: string = 'http://localhost:8085';
  urlApi: string = '/required-remainder/calculate';

  constructor(private http: HttpClient) {}

  getCall(x: number, y: number, n: number): Observable<number> {
    return this.http.get<number>(`${this.baseUrlApi}${this.urlApi}?x=${x}&y=${y}&n=${n}`);
  }

  postCall(requiredRemainderBody: RequiredRemainderBody): Observable<number> {
    return this.http.post<number>(`${this.baseUrlApi}${this.urlApi}`, requiredRemainderBody);
  }
}

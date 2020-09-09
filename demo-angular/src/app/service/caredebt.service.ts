import { Care } from './../model/care';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CaredebtService {
  private caredebtServiceUrl: string;

  constructor(private http: HttpClient) {
    this.caredebtServiceUrl = 'http://localhost:8080/api/caredebts';
  }

  public findAll(): Observable<Care[]> {
    return this.http.get<Care[]>(this.caredebtServiceUrl);
  }

}

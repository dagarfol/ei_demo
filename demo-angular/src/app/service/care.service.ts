import { Care } from './../model/care';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DatePipe } from '@angular/common';

@Injectable()
export class CareService {

  private careServiceUrl: string;

  constructor(private http: HttpClient, private datePipe: DatePipe) {
    this.careServiceUrl = 'http://localhost:8080/api/cares';
  }

  public findAll(): Observable<Care[]> {
    return this.http.get<Care[]>(this.careServiceUrl);
  }

  public save(care: Care): any {
    return this.http.post<Care>(this.careServiceUrl, care);
  }
}

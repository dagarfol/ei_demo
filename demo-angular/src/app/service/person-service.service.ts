import { HttpClient } from '@angular/common/http';
import { Person } from '../model/person';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class PersonServiceService {

  private personsUrl: string;

  constructor(private http: HttpClient) {
    this.personsUrl = 'http://localhost:8080/api/persons';
  }

  public findAll(): Observable<Person[]> {
    return this.http.get<Person[]>(this.personsUrl);
  }

  public save(person: Person): any {
    return this.http.post<Person>(this.personsUrl, person);
  }
}

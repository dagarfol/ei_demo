import { PersonServiceService } from 'src/app/service/person-service.service';
import { Person } from 'src/app/model/person';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {

  persons: Person[];

  constructor(private personService: PersonServiceService) { }

  ngOnInit(): void {
    this.personService.findAll().subscribe(data => {
      this.persons = data;
    });
  }

}

import { CareService } from 'src/app/service/care.service';
import { Router } from '@angular/router';
import { Care } from 'src/app/model/care';
import { Component, OnInit } from '@angular/core';
import { PersonServiceService } from 'src/app/service/person-service.service';
import { Person } from 'src/app/model/person';

@Component({
  selector: 'app-createcare-form',
  templateUrl: './createcare-form.component.html',
  styleUrls: ['./createcare-form.component.css']
})
export class CreatecareFormComponent implements OnInit{

  care: Care;
  persons: Person[];

  constructor(private router: Router, private careService: CareService, private personService: PersonServiceService) {
    this.care = new Care();
   }

  ngOnInit(): void {
    this.personService.findAll().subscribe(data => {
      this.persons = data;
    });
  }

   onSubmit(): void {
    this.careService.save(this.care).subscribe(result => this.showCareListing());

  }
  showCareListing(): void {
    this.router.navigate(['/cares']);
  }

}

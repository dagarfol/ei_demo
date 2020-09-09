import { PersonServiceService } from 'src/app/service/person-service.service';
import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/model/person';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-createperson-form',
  templateUrl: './createperson-form.component.html',
  styleUrls: ['./createperson-form.component.css']
})
export class CreatepersonFormComponent  {

  person: Person;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private personService: PersonServiceService) {
      this.person = new Person();
    }

  onSubmit(): void {
    this.personService.save(this.person).subscribe(result => this.showPersonListing());

  }
  showPersonListing(): void {
    this.router.navigate(['/persons']);
  }

}

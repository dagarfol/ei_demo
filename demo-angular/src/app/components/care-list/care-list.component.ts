
import { Component, OnInit } from '@angular/core';
import { Care } from 'src/app/model/care';
import { CareService } from 'src/app/service/care.service';

@Component({
  selector: 'app-care-list',
  templateUrl: './care-list.component.html',
  styleUrls: ['./care-list.component.css']
})
export class CareListComponent implements OnInit {

  cares: Care[];

  constructor(private careservice: CareService) { }

  ngOnInit(): void {
    this.careservice.findAll().subscribe(data => this.cares = data);
  }

}

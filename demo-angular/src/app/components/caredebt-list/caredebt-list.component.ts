import { CaredebtService } from 'src/app/service/caredebt.service';
import { Care } from 'src/app/model/care';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-caredebt-list',
  templateUrl: './caredebt-list.component.html',
  styleUrls: ['./caredebt-list.component.css']
})
export class CaredebtListComponent implements OnInit {

  caredebts: Care[];

  constructor(private caredebtservice: CaredebtService) { }

  ngOnInit(): void {
    this.caredebtservice.findAll().subscribe(data => this.caredebts = data);
  }
}

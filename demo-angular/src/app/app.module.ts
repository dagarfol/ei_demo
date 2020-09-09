import { CareService } from './service/care.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PersonListComponent } from './components/person-list/person-list.component';
import { CreatepersonFormComponent } from './components/createperson-form/createperson-form.component';
import { PersonServiceService } from './service/person-service.service';
import { CareListComponent } from './components/care-list/care-list.component';
import { CreatecareFormComponent } from './components/createcare-form/createcare-form.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { DatePipe } from '@angular/common';
import { CaredebtListComponent } from './components/caredebt-list/caredebt-list.component';

@NgModule({
  declarations: [
    AppComponent,
    PersonListComponent,
    CreatepersonFormComponent,
    CareListComponent,
    CreatecareFormComponent,
    CaredebtListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule
  ],
  providers: [PersonServiceService, CareService, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }

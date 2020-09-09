import { CaredebtListComponent } from './components/caredebt-list/caredebt-list.component';
import { CareListComponent } from './components/care-list/care-list.component';
import { CreatepersonFormComponent } from './components/createperson-form/createperson-form.component';
import { PersonListComponent } from './components/person-list/person-list.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreatecareFormComponent } from './components/createcare-form/createcare-form.component';

const routes: Routes = [
  { path: 'persons', component: PersonListComponent },
  { path: 'cares', component: CareListComponent },
  { path: 'addperson', component: CreatepersonFormComponent },
  { path: 'addcare', component: CreatecareFormComponent },
  { path: 'caredebts', component: CaredebtListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

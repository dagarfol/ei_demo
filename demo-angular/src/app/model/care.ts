import { Person } from './person';
export class Care {
  id: number;
  description: string;
  dateTime: Date;
  duration: string;
  parent: Person;
  babysitter: Person;
}

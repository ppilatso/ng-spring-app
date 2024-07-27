import { Role } from "./role";

export class User {
  id: string;
  username: string;
  lastname: string;
  role: Role;

  constructor() {
    this.username = '';
    this.lastname = '';
    this.role = new Role();
    this.id = '';
  }
}

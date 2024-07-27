import { Routes } from '@angular/router';
import { RoleComponent } from './Components/role/role.component';
import { UserComponent } from './Components/user/user.component';

export const routes: Routes = [
  {path : "users" , component : UserComponent},
  {path : "roles" , component : RoleComponent},
  { path: '',   redirectTo: '/users', pathMatch: 'full' },
];

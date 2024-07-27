import { Component } from '@angular/core';
import { Role } from '../../models/role';
import { RoleService } from '../../Services/role.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-role',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './role.component.html',
  styleUrl: './role.component.css'
})
export class RoleComponent {
  roleList : Role[] = [];
  // this variable is get data from model
  newRole : Role = new Role();
  // this variable determines wither we are in changing or creating new user
  creatingMode : boolean = true;
  constructor(private roleService : RoleService){
    this.getAllRoles();
  }
  //Get All roles from database
  getAllRoles(){
    this.roleService.getAll().subscribe((response : Role[])=>{
      this.roleList = response;
    });
  }
  //Delete role by id
  deleteRole(roleId : string){
    if(confirm("Are you sure you want to delete this role !!!")){
      this.roleService.Delete(roleId).subscribe(()=>{
        alert("Role Deleted Successfully");
        window.location.reload();
      });
    }
  }
  //Create new role in database
  createRole(){
    const newRole = {
      roleName : this.newRole.rolename
    }
    this.roleService.Create(newRole).subscribe(()=>{
      alert("Role Created Successfully");
      window.location.reload();
    });
  }
  //Update role
  modifyRole(){
    this.roleService.Update(this.newRole).subscribe(()=>{
      alert("Role Updated Successfully");
      window.location.reload();
    })
  }
  // function to verify the event
  openModel(role: Role = new Role()){
    if(role.id == ""){
      this.newRole = new Role();
    }else{
      this.creatingMode = false;
      this.newRole = role;
    }
  }

}

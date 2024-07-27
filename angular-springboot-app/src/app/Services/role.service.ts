import { Injectable } from '@angular/core';
import { DataService } from './data.service';
import { HttpClient } from '@angular/common/http';

const  APIUrlRole ="http://localhost:8081/api/role";

@Injectable({
  providedIn: 'root'
})
export class RoleService extends DataService{

  constructor(httpClient: HttpClient) {
    super(APIUrlRole, httpClient);
  }
}

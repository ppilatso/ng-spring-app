import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(@Inject(String) private APIUrl: string,
  private httpClient: HttpClient) { }

  getAll(): Observable<any> {
    return this.httpClient.get(this.APIUrl);
  }

  getById(id: number): Observable<any> {
    return this.httpClient.get(this.APIUrl + '/' + id);
  }

  Create(data: any): Observable<any> {
    return this.httpClient.post(this.APIUrl, data);
  }

  Update(data: any): Observable<any> {
    return this.httpClient.put(this.APIUrl + '/' + data.id, data);
  }

  Delete(id: any): Observable<any> {
    return this.httpClient.delete(this.APIUrl + '/' + id);
  }
}

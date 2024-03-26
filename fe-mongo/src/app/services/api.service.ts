import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, shareReplay } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private apiUrl = 'http://localhost:8070/users'
  
  constructor(private http: HttpClient) { }

  public getData(): Observable<any>{
    return this.http.get<any>(this.apiUrl)
  }

  public getAllProducts(): Observable<User[]>{

    return this.http.get<User[]>(this.apiUrl)
    .pipe(
      shareReplay()
    )
  }
}

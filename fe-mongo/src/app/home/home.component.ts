import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{
  
  users$: Observable<User[]> = new Observable<User[]>()


  constructor(private apiService: ApiService){
  }
  
  ngOnInit(): void {
    this.getData()
  }

  getData(){
    this.users$ = this.apiService.getAllProducts()
  }

}

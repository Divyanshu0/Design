import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {Observable, Subject} from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http:HttpClient) { }
  url='http://localhost:8080';
  createUser(user){
    return this.http.post(this.url+'/registration',user)
  }
  loginUser(login) {
    
    return this.http.get(`${this.url}/login/${login}`);
    
  }
  getUser(){
    return this.http.get(`${this.url}/user`);
  }

  postAdmin(message,type){
    return this.http.post(`${this.url}/${type}`,message);
  }

}

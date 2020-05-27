import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../shared/user-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private service:UserServiceService ,private router:Router) { }
  notification:any;
  ngOnInit(): void {
this.getNotification();
  }
getNotification(){
  this.service.getUser().subscribe((messages)=>{
    this.notification=messages;
  })
}
logout(){
this.router.navigate(['login']);
}
}

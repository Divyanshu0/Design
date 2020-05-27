import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserServiceService } from '../shared/user-service.service';

@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdmindashboardComponent implements OnInit {

  constructor(   private formBuilder: FormBuilder,
                 private router: Router,private service:UserServiceService) { }

  adminForm:FormGroup;
  submitted = false;
  notificationType=null;
  messageValue=null;
 
  ngOnInit(): void {
    this.adminForm = this.formBuilder.group({
      eventType: ['Holiday', Validators.required],
      subject:  ['', Validators.required],
      message: ['', Validators.required],
    })
    
  }
  Event: any=['Holiday','Event','Urgent Help','Nagarro news','New Policy'];

  get f() { return this.adminForm.controls; }

  onSubmit(){
    this.submitted = true;
     
    
    if(this.adminForm.get('message').value===""){
      return;
    }
    //this.notificationType=this.adminForm.get('eventType').value;
    this.messageValue=this.adminForm.get('message').value;
    switch(this.adminForm.get('eventType').value){
      case "Holiday":{this.notificationType='holiday';
                  break;}
      case "Event":{this.notificationType='event';
                  break;}
      case "Urgent Help":{this.notificationType='urgentHelp';
                  break;}
      case "Nagarro news":{this.notificationType='news';
                  break;}
      case "New Policy":{this.notificationType='policy';
                  break;}

    }
    
    this.postMessage(this.messageValue,this.notificationType);
    console.log(this.adminForm.value)
  }
  postMessage(message,notificationType){
    this.service.postAdmin(message,notificationType).subscribe((m)=>{
      console.log(m);
    })
  }
}

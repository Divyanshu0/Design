import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { invalid } from '@angular/compiler/src/render3/view/util';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserServiceService } from '../shared/user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private formBuilder: FormBuilder,
    private route: Router, private service:UserServiceService) { }
  loginForm:FormGroup;
  submitted = false;
   userValue=null;

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password:  ['', Validators.required]
    })

  }

  get f() { return this.loginForm.controls; }

  invalid: boolean = false;
  handleLogin() {
    const val: String = this.loginForm.get('email').value;
    let [_, domain] = val.split("@");

    if (domain === 'admin.com') {
      if (this.loginForm.get('email').value === "abhishek.saxena02@admin.com" && this.loginForm.get('password').value==="pass@1234") {
        this.route.navigate(['admindashboard']);
      } else {
        this.invalid = true;
      }
    } else if (domain === 'nagarro.com') {
        this.loginUser(val);
    }else {
      this.invalid = true;
    }

    this.submitted = true;

    // stop here if form is invalid
    if (this.loginForm.invalid) {
        return;
    }

  }
  loginUser(user){
    this.service.loginUser(user).subscribe((user)=>{

      if(user){
        this.route.navigate(['dashboard']);
      }
      else{
        this.invalid = true;
      }
  })
}
}


  



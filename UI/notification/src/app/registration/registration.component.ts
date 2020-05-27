import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators,FormBuilder} from '@angular/forms';
import { Router } from '@angular/router';
import { UserServiceService } from '../shared/user-service.service';




@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,private service:UserServiceService) { }
  userdetailsForm:FormGroup;
  submitted = false;
  userValue:any                                                                                                                                                                                                                                                                                                                                         ;

  ngOnInit(): void {
     
  
    this.userdetailsForm = this.formBuilder.group({
      name:  ['', Validators.required],
      dob:  ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone:  ['', Validators.required],
      password:  ['', Validators.required]
    })
  }

  get f() { return this.userdetailsForm.controls; }


  evalid:boolean=false;
  emailValidation():boolean {
   const val:String = this.userdetailsForm.get('email').value;
     let [_, domain] = val.split("@"); 
     if (domain !== "nagarro.com") {
       return this.evalid =true;
       }
       return this.evalid=false;
     }
   
     phvalid:boolean=false;
     phoneValidation():boolean{
      const Phoneval:Number = this.userdetailsForm.get('phone').value;
      if(Phoneval.toString().length ==10){
        console.log("working");
        return this.phvalid=false;
      }
      else{
        return this.phvalid=true;
      }
     }
     


  onSubmit() {
    if(this.emailValidation()){
      return ;
    }

    if(this.phoneValidation()){
      return ;
    }
   
    this.submitted = true;

    // stop here if form is invalid
    if (this.userdetailsForm.invalid) {
        return;
    }
    this.userValue=this.userdetailsForm.value;
    this.registerUser(this.userValue);
    this.router.navigate(['login']);


    alert('SUCCESS!! :-)');
}
registerUser(user){
this.service.createUser(user).subscribe((user)=>{
  console.log(user);
})
}
  

}

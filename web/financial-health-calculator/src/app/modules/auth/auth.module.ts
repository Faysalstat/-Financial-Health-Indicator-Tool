import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { RouterModule } from '@angular/router';
import { SignUpComponent } from './sign-up/sign-up.component';
import { MaterialModule } from 'src/material.module';
import { ButtonModule } from 'primeng/button';
import { CheckboxModule } from 'primeng/checkbox';
import { InputTextModule } from 'primeng/inputtext';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PrimeNgModule } from 'src/primeng.module';
import { PasswordModule } from 'primeng/password';


@NgModule({
  declarations: [LoginComponent],
  imports: [
    CommonModule,
    ButtonModule,
    CheckboxModule,
    InputTextModule,
    FormsModule,
    PasswordModule,
    FormsModule,
    ReactiveFormsModule,
    PrimeNgModule,
    MaterialModule,
    RouterModule.forChild([
      { path: '', component: LoginComponent},
      { path: 'signup', component: SignUpComponent}
  ])
  ]
})
export class AuthModule { }

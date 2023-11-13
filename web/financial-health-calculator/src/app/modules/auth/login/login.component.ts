import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ConfirmationService, MessageService } from 'primeng/api';
import { AuthService } from '../../services/auth.service';
import { NotificationService } from '../../services/notification.service';
import { User } from '../auth.model';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: [
    `
      :host ::ng-deep .pi-eye,
      :host ::ng-deep .pi-eye-slash {
        transform: scale(1.6);
        margin-right: 1rem;
        color: var(--primary-color) !important;
      }
      .radio-group {
        display: flex;
        flex-direction: column;
        margin: 15px 0;
        align-items: flex-start;
      }

      .radio-button {
        margin: 5px;
      }
    `,
  ],
  providers: [ConfirmationService, MessageService],
})
export class LoginComponent {
  valCheck: string[] = ['remember'];
  password!: string;
  loginForm!: FormGroup;
  message!: string;
  projects: any = [];
  selectedProject!: any;
  displayProjectSelection: boolean = false;
  authDetails!:any;
  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private notificationService: NotificationService
  ) {}

  ngOnInit(): void {
    this.prepareForm(null);
  }
  prepareForm(formData: any) {
    formData = new User();
    this.loginForm = this.formBuilder.group({
      username: [formData.username, [Validators.required]],
      password: [formData.password, [Validators.required]],
      // address: [formData.personAddress],
    });
  }
  signIn() {
    const params: Map<string, any> = new Map();
    const user = {
      username: this.loginForm.get('username')?.value,
      password: this.loginForm.get('password')?.value,
    };
    params.set('user', user);
    this.authService.signIn(params).subscribe({
      next: (res) => {
        if (res.isSuccess) {
          this.authDetails = res.body;
          localStorage.setItem('userId', this.authDetails.userid);
        } else {
          this.notificationService.showMessage(
            'ERROR!',
            'Authentication Failed ' + res.message,
            'OK',
            2000
          );
        }
      },
      error: (err) => {
        this.notificationService.showErrorMessage(
          'ERROR!',
          err.message,
          'OK',
          2000
        );
      },
      complete: () => {},
    });
  }
}

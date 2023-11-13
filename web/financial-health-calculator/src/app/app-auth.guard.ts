import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './modules/services/auth.service';
import { NotificationService } from './modules/services/notification.service';

@Injectable({
  providedIn: 'root',
})
export class AppAuthGuard implements CanActivate {
  constructor(
    private router: Router,
    private authService :AuthService,
    private notificationService: NotificationService
  ){}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
    const idToken = localStorage.getItem('token');
    return this.verify(idToken);
  }
  canActivateChild(
    childRoute: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | boolean
    | UrlTree
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree> {
    const idToken = localStorage.getItem('token');
    return this.verify(idToken);
  }
  async verify(token: any) {
    if (!token) {
      this.router.navigate(['auth']);
    }
    let authenticated = await this.authService.isLoggedIn(token);
    if (!authenticated.body.status) {
      this.router.navigate(['auth']);
    }
    // return authenticated.body.status;
    return true;
  }

}

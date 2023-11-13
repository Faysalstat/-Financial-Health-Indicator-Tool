import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationUrls } from '../utils/api-constants';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) {}
  public signIn(queryParams: Map<string, any>): Observable<any> {
    return this.http.post(AuthenticationUrls.LOGIN, queryParams.get('user'));
  }
  public signOut(queryParams: Map<string, any>): Observable<any> {
    return this.http.post(AuthenticationUrls.SIGN_OUT, queryParams.get('user'));
  }
  public addUser(queryParams: Map<string, any>): Observable<any> {
    return this.http.post(AuthenticationUrls.ADD_USER, queryParams.get('user'));
  }
  public isLoggedIn(token: any): Promise<any> {
    let params = new HttpParams();
    params = params.append('token', token);
    return this.http
      .get(AuthenticationUrls.CHECK_IS_LOGGEDIN, { params: params })
      .toPromise();
  }
}

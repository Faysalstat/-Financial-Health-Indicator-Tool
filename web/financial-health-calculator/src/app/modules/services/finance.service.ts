import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FinanceServiceUrls } from '../utils/api-constants';

@Injectable({
  providedIn: 'root'
})
export class FinanceService {

  constructor(private http: HttpClient) {}
  
  public saveFinaceRecord(queryParams: Map<string, any>): Observable<any> {
    return this.http.post(FinanceServiceUrls.SAVE_FINACE_RECORD, queryParams.get('model'));
  }
}

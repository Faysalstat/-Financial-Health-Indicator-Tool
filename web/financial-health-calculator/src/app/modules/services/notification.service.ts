import { Injectable } from '@angular/core';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root',
})
export class NotificationService {
  constructor() {}
  public showMessage(title: string, msg: string, close: string, timer: number) {
    return Swal.fire({
      title: title,
      text: msg,
      confirmButtonText: close,
      timer: timer,
    });
  }
  public showErrorMessage(
    title: string,
    msg: string,
    close: string,
    timer: number
  ) {
    return Swal.fire({
      title: title,
      text: msg,
      confirmButtonText: close,
      icon: 'error',
      timer: timer,
    });
  }

  public showNotFoundErrorMessage(msg: string) {
    return Swal.fire({
      title: 'ERROR',
      text: msg,
      confirmButtonText: 'OK',
      icon: 'error',
      timer: 2000,
    });
  }
}

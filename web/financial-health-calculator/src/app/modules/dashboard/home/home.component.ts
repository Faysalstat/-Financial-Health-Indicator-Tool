import { Component, OnInit } from '@angular/core';
import { FinanceService } from '../../services/finance.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(
    private financeService:FinanceService
  ) { }

  ngOnInit(): void {
    this.financeService.testConnection().subscribe({
      next:(res)=>{
        console.log(res)
      },
      error:(err)=>{
        console.log(err)
      }
    })
  }

}

import { Component, OnInit } from '@angular/core';
import { NotificationService } from '../../services/notification.service';
import { FinanceService } from '../../services/finance.service';

@Component({
  selector: 'app-balance-sheet',
  templateUrl: './balance-sheet.component.html',
  styleUrls: ['./balance-sheet.component.scss']
})
export class BalanceSheetComponent implements OnInit {
  years:any[]=[];
  months:any[]=[];
  today = new Date();
  // selectedYear = this.today.getFullYear().toString();
  // selectedMonth = this.today.getDay();
  query:any;
  constructor(
    private notificationService:NotificationService,
    private financeService:FinanceService
  ) {
    this.query = {
      year:this.today.getFullYear().toString(),
      month: (this.today.getMonth()+1).toString().padStart(2, '0')
    }
    for(let i=1;i<50;i++){
      this.years.push({label:(2000+i).toString(),value:(2000+i).toString()});
    }
    this.months = [
      { label: 'Select Month', value: '' },
      { label: 'January', value: '01' },
      { label: 'February', value: '02' },
      { label: 'March', value: '03' },
      { label: 'April', value: '04' },
      { label: 'May', value: '05' },
      { label: 'June', value: '06' },
      { label: 'July', value: '07' },
      { label: 'August', value: '08' },
      { label: 'September', value: '09' },
      { label: 'October', value: '10' },
      { label: 'November', value: '11' },
      { label: 'December', value: '12' },
    ];
  }

  ngOnInit(): void {
  }
  fetchRecords(){
    const params: Map<string, any> = new Map();
    params.set('query', this.query);
  }
}

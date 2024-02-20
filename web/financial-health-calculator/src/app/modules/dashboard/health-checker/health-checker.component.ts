import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, MinValidator, Validators } from '@angular/forms';
import { FinanceService } from '../../services/finance.service';

@Component({
  selector: 'app-health-checker',
  templateUrl: './health-checker.component.html',
  styleUrls: ['./health-checker.component.scss']
})
export class HealthCheckerComponent implements OnInit {
  inputForm!: FormGroup;
  today = new Date();
  years:any[]=[{label:"Select Year",value:''}];
  months:any[]=[];
  constructor(
    private formBuilder:FormBuilder,
    private financeService: FinanceService
  ) {
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
    this.prepareForm();
    this.generateYearAndMonths();
  }
  prepareForm(){
    this.inputForm = this.formBuilder.group({
      year:[this.today.getFullYear().toString(),[Validators.required]],
      month:[(this.today.getMonth()+1).toString(),[Validators.required]],
      assetAmount:[0,[Validators.required,Validators.min(1)]],
      debtAmount:[0,[Validators.required,Validators.min(1)]],
      incomeAmount:[0,[Validators.required,Validators.min(1)]],
      expenseAmount:[0,[Validators.required,Validators.min(1)]]
    });
  }
  generateYearAndMonths(){
    for(let i=1;i<50;i++){
      this.years.push({label:(2000+i).toString(),value:(2000+i).toString()});
    }
  }
  calculate(){
    // let model = this.inputForm.value;
    let model = {
      year: "2024",
      month: "01",
      assetAmount: 1000,
      debtAmount: 2000,
      incomeAmount: 12000,
      expenseAmount: 3000
    }
    const params: Map<string, any> = new Map();
    params.set('model', model);
    this.financeService.saveFinaceRecord(params).subscribe({
      next:(res)=>{
        console.log(res)
      },
      error:(err)=>{

      },
      complete:()=>{

      }
    })

  }
}

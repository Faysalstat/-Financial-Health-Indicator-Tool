import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { HealthCheckerComponent } from './health-checker/health-checker.component';
import { HealthVisualsComponent } from './health-visuals/health-visuals.component';
import { RouterModule } from '@angular/router';
import { MaterialModule } from 'src/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BalanceSheetComponent } from './balance-sheet/balance-sheet.component';


@NgModule({
  declarations: [
    HomeComponent,
    HealthCheckerComponent,
    HealthVisualsComponent,
    BalanceSheetComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MaterialModule,
    RouterModule.forChild([
      { path: '', component: HomeComponent,children:[
        { path: 'health-calculator', component: HealthCheckerComponent},
        { path: 'charts', component: HealthVisualsComponent},
        { path: 'balance-sheet', component: BalanceSheetComponent}
      ]},
     
  ])
  ]
})
export class DashboardModule { }

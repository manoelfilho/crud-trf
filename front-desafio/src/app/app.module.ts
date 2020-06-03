import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, FormBuilder } from '@angular/forms';
import { EmpresasComponent } from './empresas/empresas.component';
import { EmpresasNovoComponent } from './empresas-novo/empresas-novo.component';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    EmpresasComponent,
    EmpresasNovoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule
  ],
  providers: [
    FormBuilder
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
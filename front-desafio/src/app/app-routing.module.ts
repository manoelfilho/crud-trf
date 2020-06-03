import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { EmpresasComponent } from './empresas/empresas.component';
import { EmpresasNovoComponent } from './empresas-novo/empresas-novo.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: "/empresas",
    pathMatch: 'full'
  },
  {
    path: 'empresas',
    component: EmpresasComponent,
    data: { title: 'Lista de Empresas' }
  },
  {
    path: 'empresas/editar/:id',
    component: EmpresasNovoComponent,
    data: { title: 'Edição de empresa' }
  },
  {
    path: 'empresas/adicionar',
    component: EmpresasNovoComponent,
    data: { title: 'Adicionar Empresa' }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

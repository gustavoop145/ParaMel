import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import VagasList from './VagasList';
import VagaForm from './VagaForm';
import Login from './Login';
import Register from './Register';

export default function App(){
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<VagasList/>} />
        <Route path='/vaga/:id' element={<VagaForm/>} />
        <Route path='/login' element={<Login/>} />
        <Route path='/register' element={<Register/>} />
      </Routes>
    </BrowserRouter>
  );
}

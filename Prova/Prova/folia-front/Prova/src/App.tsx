import { useReducer, useState } from 'react'
import './App.css'
import api from './api/axioApi';
import IVeiculo from './model/veiculo';
import IAcessorio from './model/acessorio';

function findAllVeiculo() {
  api.get('veiculo')
    .then(function (response: any) {

      console.log(response);
    })
    .catch(function (error) {

      console.log(error);
    })
    .finally(function () {
    });
}

function App() {

  function postVeiculo() {

    const acessorioModel: IAcessorio = {
      nome: formData.acessorio,
    };

    const veiculo: IVeiculo = {
      modelo: formData.modelo,
      anoFabricacao: formData.anoFabricacao,
      placa: formData.placa,
      acessorio: [acessorioModel]
    };

    
    api.post('veiculo', veiculo)
      .then(function (response: any) {

        console.log(response);
      })
      .catch(function (error) {

        console.log(error);
      })
      .finally(function () {
      });
  }

  const [formData, setFormData] = useState({
    modelo: '',
    anoFabricacao: 2000,
    placa: '',
    acessorio: ''
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  }

  return (
    <>
      <div className="mt-6 ml-12 mr-12">
        <form onSubmit={postVeiculo}>
          <div className="space-y-12">
            <div className="border-b border-gray-900/10 pb-12">
              <h2 className="text-base font-semibold leading-7 text-gray-900">Veiculo</h2>
            </div>

            <div className="border-b border-gray-900/10 pb-12">
              <div className="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
                <div className="sm:col-span-3">
                  <label htmlFor="modelo" className="block text-sm font-medium leading-6 text-gray-900">
                    Modelo
                  </label>
                  <div className="mt-2">
                    <input
                      id="modelo"
                      name="modelo"
                      type="text"
                      value={formData.modelo}
                      onChange={handleChange}
                      className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                    />
                  </div>
                </div>

                <div className="sm:col-span-3">
                  <label htmlFor="anoFabricacao" className="block text-sm font-medium leading-6 text-gray-900">
                    Ano de Fabricação
                  </label>
                  <div className="mt-2">
                    <input
                      id="anoFabricacao"
                      name="anoFabricacao"
                      type="number"
                      value={formData.anoFabricacao}
                      onChange={handleChange}
                      className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                    />
                  </div>
                </div>
                <div className="sm:col-span-4">
                  <label htmlFor="placa" className="block text-sm font-medium leading-6 text-gray-900">
                    Placa
                  </label>
                  <div className="mt-2">
                    <input
                      id="placa"
                      name="placa"
                      type="text"
                      value={formData.placa}
                      onChange={handleChange}
                      className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                    />
                  </div>
                </div>

                <div className="col-span-full">
                  <label htmlFor="acessorio" className="block text-sm font-medium leading-6 text-gray-900">
                    Acessorios
                  </label>
                  <div className="mt-2">
                    <input
                      id="acessorio"
                      name="acessorio"
                      type="text"
                      value={formData.acessorio}
                      onChange={handleChange}
                      className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                    />
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div className="mt-6 flex items-center justify-end gap-x-6">
            <button type="button" className="text-sm font-semibold leading-6 text-gray-900">
              Cancel
            </button>
            <button
              type='button'
              onClick={postVeiculo}
              className="rounded-md bg-indigo-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
            >
              Save
            </button>
          </div>
        </form >
      </div>
    </>
  )
}

export default App

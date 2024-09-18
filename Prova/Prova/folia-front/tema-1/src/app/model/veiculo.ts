import IAcessorio from "./acessorio";

export default interface IVeiculo{
    id?: number;
    modelo: string;
    anoFabricacao: string;
    placa: string
    acessorio: IAcessorio;
}
import IAcessorio from "./acessorio";

export default interface IVeiculo{
    id?: number;
    modelo: string;
    anoFabricacao: number;
    placa: string;
    acessorio: IAcessorio[];
}
import IVeiculo from "./model/veiculo";

const URL = "localhost:8080/api";

const axios = require('axios').default;



function Submit() {
  axios.get(URL + "veiculo")
  .then(function (response) {
    // handle success
    console.log(response);
  })
  .catch(function (error) {
    // handle error
    console.log(error);
  })
  .finally(function () {
    // always executed
  });
}

export default function Home() {

  let veiculo: IVeiculo;

  return (
    <div className="grid grid-rows-[20px_1fr_20px] items-center justify-items-center min-h-screen p-8 pb-20 gap-16 sm:p-20 font-[family-name:var(--font-geist-sans)]">
      <main className="flex flex-col gap-8 row-start-2 items-center sm:items-start">

        <form action={Submit}>
          <input name="query" />
          <button type="submit">Search</button>
        </form>

      </main>
      <footer className="row-start-3 flex gap-6 flex-wrap items-center justify-center">
      </footer>
    </div>
  );
}

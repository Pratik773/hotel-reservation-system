function Home() {

    return (

        <div className="min-h-screen">

            <section className="h-[90vh] bg-gradient-to-r from-blue-700 to-indigo-700 flex justify-center items-center text-white">

                <div className="text-center">

                    <h1 className="text-6xl font-bold">

                        Find Your Perfect Stay

                    </h1>

                    <p className="mt-6 text-2xl">

                        Luxury Hotels at Affordable Prices

                    </p>

                    <button
                        className="mt-10 bg-white text-blue-700 px-8 py-4 rounded-xl font-bold hover:scale-105 duration-300"
                    >

                        Explore Hotels

                    </button>

                </div>

            </section>

        </div>

    );

}

export default Home;
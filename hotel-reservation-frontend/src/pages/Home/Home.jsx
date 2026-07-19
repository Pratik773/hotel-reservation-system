import heroImage from "../../assets/images/hero.avif";

function Home() {
  return (
    <div>
      <section
        className="relative h-screen bg-cover bg-center"
        style={{ backgroundImage: `url(${heroImage})` }}
      >
        <div className="absolute inset-0 bg-black/50"></div>

        <div className="relative z-10 flex flex-col justify-center items-center h-full text-white text-center px-4">

          <h1 className="text-5xl md:text-7xl font-bold">
            Find Your Perfect Stay
          </h1>

          <p className="mt-6 text-xl max-w-2xl">
            Discover luxury hotels, affordable stays, and unforgettable experiences.
          </p>

          <button className="mt-10 bg-blue-600 hover:bg-blue-700 px-8 py-4 rounded-xl text-lg font-semibold transition duration-300">
            Explore Hotels
          </button>

        </div>
      </section>
    </div>
  );
}

export default Home;
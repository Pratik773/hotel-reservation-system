import heroImage from "../../assets/images/hero.avif";
import SearchBar from "./SearchBar";
import { motion } from "framer-motion";

function Hero() {
  return (
    <section
      className="relative h-screen bg-cover bg-center"
      style={{
        backgroundImage: `url(${heroImage})`,
      }}
    >
      {/* Dark Overlay */}
      <div className="absolute inset-0 bg-black/50"></div>

      {/* Content */}
      <div className="relative z-10 flex flex-col justify-center items-center h-full text-center px-4">

        <motion.h1
          initial={{ opacity: 0, y: -40 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ duration: 0.8 }}
          className="text-white text-5xl md:text-7xl font-bold"
        >
          Find Your Perfect Stay
        </motion.h1>

        <motion.p
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          transition={{ delay: 0.4 }}
          className="text-gray-200 text-xl mt-6 max-w-2xl"
        >
          Discover luxury hotels, budget stays and unforgettable travel
          experiences.
        </motion.p>

        <motion.div
          initial={{ opacity: 0, y: 60 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ delay: 0.7 }}
          className="mt-12 w-full flex justify-center"
        >
          <SearchBar />
        </motion.div>

      </div>
    </section>
  );
}

export default Hero;
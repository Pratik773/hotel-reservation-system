import Hero from "../../components/home/Hero";
import SearchCard from "../../components/home/SearchCard";
import FeaturedHotels from "../../components/home/FeaturedHotels";
import WhyChooseUs from "../../components/home/WhyChooseUs";
import Testimonials from "../../components/home/Testimonials";

function Home() {
    return (
        <>
            <Hero />
            <SearchCard />
            <FeaturedHotels />
            <WhyChooseUs />
            <Testimonials />
        </>
    );
}

export default Home;
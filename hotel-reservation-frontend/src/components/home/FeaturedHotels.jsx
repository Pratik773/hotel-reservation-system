import HotelCard from "./HotelCard";

const hotels = [

    {
        id:1,
        name:"Grand Palace",
        city:"Mumbai",
        rating:4.8,
        price:4200,
        image:"https://images.unsplash.com/photo-1566073771259-6a8506099945?w=900",
        description:"Luxury hotel with sea view."
    },

    {
        id:2,
        name:"Royal Resort",
        city:"Goa",
        rating:4.9,
        price:5600,
        image:"https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?w=900",
        description:"Beachfront resort."
    },

    {
        id:3,
        name:"Mountain View",
        city:"Manali",
        rating:4.7,
        price:3900,
        image:"https://images.unsplash.com/photo-1582719478250-c89cae4dc85b?w=900",
        description:"Peaceful stay in mountains."
    }

];

function FeaturedHotels(){

    return(

        <section className="py-20 bg-slate-100">

            <div className="max-w-7xl mx-auto px-6">

                <h2 className="text-4xl font-bold text-center">

                    Featured Hotels

                </h2>

                <p className="text-center text-gray-500 mt-3">

                    Handpicked hotels for your perfect vacation.

                </p>

                <div className="grid md:grid-cols-3 gap-8 mt-14">

                    {
                        hotels.map(hotel=>(
                            <HotelCard
                                key={hotel.id}
                                hotel={hotel}
                            />
                        ))
                    }

                </div>

            </div>

        </section>

    );

}

export default FeaturedHotels;
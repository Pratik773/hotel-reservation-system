import { Building2, Users, BedDouble, Globe } from "lucide-react";

function Stats(){

    const stats=[

        {
            title:"Hotels",
            value:"250+",
            icon:<Building2 size={40}/>
        },

        {
            title:"Customers",
            value:"15K+",
            icon:<Users size={40}/>
        },

        {
            title:"Rooms",
            value:"5000+",
            icon:<BedDouble size={40}/>
        },

        {
            title:"Cities",
            value:"40+",
            icon:<Globe size={40}/>
        }

    ];

    return(

        <section className="py-20">

            <div className="max-w-7xl mx-auto grid md:grid-cols-4 gap-8 px-6">

                {
                    stats.map((item,index)=>(

                        <div
                            key={index}
                            className="bg-white rounded-2xl shadow-lg p-8 text-center hover:shadow-xl transition"
                        >

                            <div className="flex justify-center text-blue-600">

                                {item.icon}

                            </div>

                            <h2 className="text-4xl font-bold mt-4">

                                {item.value}

                            </h2>

                            <p className="text-gray-500 mt-2">

                                {item.title}

                            </p>

                        </div>

                    ))
                }

            </div>

        </section>

    );

}

export default Stats;